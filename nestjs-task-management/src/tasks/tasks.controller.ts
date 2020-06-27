import { Controller, Get, Post, Body, Param, Delete} from '@nestjs/common';
import { TasksService } from './tasks.service';
import { Task } from './task.model';

@Controller('tasks')
export class TasksController {
    constructor(private tasksService:TasksService) {}

    @Get()
    getAllTasks(): Task[] {
        return this.tasksService.getAllTasks();
    }

    @Get(':id')
    getTaskById(
        @Param('id') id:string
    ): Task {
        return this.tasksService.getTaskById(id);
    }

    @Post()
    async createTask(
        @Body('title') title: string,
        @Body('description') description: string,
    ): Promise<Task>{
        return this.tasksService.createTask(title, description);
    }

    @Delete(':id')
    deleteTask(
        @Param('id') id:string
    ): Task {
        return this.tasksService.deleteTask(id);
    }
}
