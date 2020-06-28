import { Controller, Get, Post, Body, Param, Delete, Patch, Query, UsePipes, ValidationPipe} from '@nestjs/common';
import { TasksService } from './tasks.service';
import { Task, TaskStatus } from './task.model';
import { CreateTaskDTO } from './dto/create-task.dto';
import { GetTasksFilterDTO } from './dto/get-tasks-filter.dto';
import { TaskStatusValidationPipe } from './pipes/task-status-validation.pipe';

@Controller('tasks')
export class TasksController {
    constructor(private tasksService:TasksService) {}

    @Get()
    getTasks(@Query(ValidationPipe) filterDTO: GetTasksFilterDTO): Task[] {
        return Object.keys(filterDTO).length ? this.tasksService.getTasksWithFilters(filterDTO) : this.tasksService.getAllTasks();
    }

    @Get('/:id')
    getTaskById(@Param('id') id: string): Task {
        return this.tasksService.getTaskById(id);
    }

    @Post()
    @UsePipes(ValidationPipe)
    async createTask(@Body() createTaskDTO: CreateTaskDTO): Promise<Task>{
        return this.tasksService.createTask(createTaskDTO);
    }

    @Delete('/:id')
    deleteTask(@Param('id') id: string): void {
        this.tasksService.deleteTask(id);
    }

    @Patch('/:id/status')
    async updateTaskStatus(
        @Param('id') id: string,
        @Body('status', TaskStatusValidationPipe) status: TaskStatus
    ): Promise<Task> {
        return this.tasksService.updateTaskStatus(id, status);
    }
}
