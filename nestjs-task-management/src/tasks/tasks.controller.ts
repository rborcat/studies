import { Controller, Get, Post, Body, Param, Delete, Patch} from '@nestjs/common';
import { TasksService } from './tasks.service';
import { Task, TaskStatus } from './task.model';
import { CreateTaskDTO } from './dto/create-task.dto';

@Controller('tasks')
export class TasksController {
    constructor(private tasksService:TasksService) {}

    @Get()
    getAllTasks(): Task[] {
        return this.tasksService.getAllTasks();
    }

    @Get('/:id')
    getTaskById(@Param('id') id: string): Task {
        return this.tasksService.getTaskById(id);
    }

    @Post()
    async createTask(@Body() createTaskDTO: CreateTaskDTO): Promise<Task>{
        return this.tasksService.createTask(createTaskDTO);
    }

    @Delete('/:id')
    deleteTask(@Param('id') id: string): void {
        this.tasksService.deleteTask(id);
    }

    @Patch('/:id/status')
    async updateTaskStatus(@Param('id') id: string, @Body('status') status: TaskStatus): Promise<Task> {
        return this.tasksService.updateTaskStatus(id, status);
    }
}
