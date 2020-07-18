import { Repository, EntityRepository } from "typeorm";
import { User } from "./user.entity";
import { AuthCredentialsDto } from "./dto/auth-credentials.dto";
import { ConflictException, InternalServerErrorException } from "@nestjs/common";

@EntityRepository(User)
export class UserRepository extends Repository<User> {
    async signUp(authCredentialsDto: AuthCredentialsDto): Promise<void> {
        const { username, password } = authCredentialsDto;
        const DUPLICATED_USER_NAME_CODE = '23505';

        const user = new User();
        user.username = username;
        user.password = password;

        try {
            await user.save();
        } catch (error) {
            if (error.code === DUPLICATED_USER_NAME_CODE) {
                throw new ConflictException('Username already exists');
            } else {
                throw new InternalServerErrorException();
            }
        }
    }
}