import { Task, TaskStatus } from './task.model';
import { CreateTaskDTO } from './dto/create-task.dto';
import { GetTasksFilterDTO } from './dto/get-tasks-filter.dto';
export declare class TasksService {
    private tasks;
    getAllTasks(): Task[];
    getTasksWithFilters(filterDTO: GetTasksFilterDTO): Task[];
    getTaskById(id: string): Task;
    createTask(createTaskDTO: CreateTaskDTO): Task;
    deleteTask(id: string): void;
    updateTaskStatus(id: string, status: TaskStatus): Task;
}
