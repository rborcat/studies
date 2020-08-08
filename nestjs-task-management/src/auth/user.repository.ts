import { Repository, EntityRepository } from "typeorm";
import { ConflictException, InternalServerErrorException, Logger } from "@nestjs/common";
import * as bcrypt from 'bcryptjs';
import { User } from "./user.entity";
import { AuthCredentialsDto } from "./dto/auth-credentials.dto";

@EntityRepository(User)
export class UserRepository extends Repository<User> {
    private logger = new Logger('UserRepository');

    async signUp(authCredentialsDto: AuthCredentialsDto): Promise<void> {
        const { username, password } = authCredentialsDto;
        const DUPLICATED_USER_NAME_CODE = '23505';

        this.logger.verbose(`Creating user: ${username}`);
        const user = new User();
        user.username = username;
        user.salt = await bcrypt.genSalt();;
        user.password = await this.hashPassword(password, user.salt);

        try {
            await user.save();
            this.logger.verbose(`User created: ${username}`);
        } catch (error) {
            if (error.code === DUPLICATED_USER_NAME_CODE) {
                this.logger.verbose(`Failed to create user: ${username} - user already exists`);
                throw new ConflictException('Username already exists');
            } else {
                throw new InternalServerErrorException();
            }
        }
    }

    async validateUserPassword(authCredentialsDto: AuthCredentialsDto): Promise<string>{
        const { username, password } = authCredentialsDto;
        const user = await this.findOne({ username });

        if (user && await user.validatePassword(password)) {
            return user.username;
        }
        return null;
    }

    private async hashPassword(password: string, salt: string): Promise<string> {
        return bcrypt.hash(password, salt);
    }
}