import { Controller, Get, Post } from '@nestjs/common';
import { TasksService } from './tasks.service';
import { Task } from './task.model';
import { TasksModule } from './tasks.module';

@Controller('tasks')
export class TasksController {
    constructor(private tasksService:TasksService) {}

    @Get()
    getAllTasks(): Task[] {
        return this.tasksService.getAllTasks();
    }

    @Post()
    createTask(title:string, description: string) {
        return this.tasksService.createTask(title, description);
    }
}
