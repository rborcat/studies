import { Controller, Post, Body, ValidationPipe } from '@nestjs/common';
import { AuthCredentialsDto } from './dto/auth-credentials.dto';
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
    constructor(
        private authService: AuthService,
    ) {}

    @Post('/signup')
    signUp(@Body(ValidationPipe) authCrendentialsDto: AuthCredentialsDto): Promise<void> {
        return this.authService.signUp(authCrendentialsDto);
    }

    @Post('/signin')
    singIn(@Body(ValidationPipe) authCrendentialsDto: AuthCredentialsDto) {
        return this.authService.signIn(authCrendentialsDto);
    }
}
