import { Task } from "./task.entity";
import { Repository } from "typeorm";
import { CreateTaskDTO } from "./dto/create-task.dto";
import { GetTasksFilterDTO } from "./dto/get-tasks-filter.dto";
export declare class TaskRepository extends Repository<Task> {
    getTasks(filterDTO: GetTasksFilterDTO): Promise<Task[]>;
    createTask(createTaskDTO: CreateTaskDTO): Promise<Task>;
}
