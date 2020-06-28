"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TaskStatusValidationPipe = void 0;
const common_1 = require("@nestjs/common");
const task_model_1 = require("../task.model");
class TaskStatusValidationPipe {
    constructor() {
        this.allowedStatuses = [
            task_model_1.TaskStatus.OPEN,
            task_model_1.TaskStatus.IN_PROGRESS,
            task_model_1.TaskStatus.DONE
        ];
    }
    transform(value) {
        value = value.toUpperCase();
        if (!this.isValidStatus(value)) {
            throw new common_1.BadRequestException(`"${value} is an invalid status`);
        }
        return value;
    }
    isValidStatus(status) {
        return this.allowedStatuses.indexOf(status) !== -1;
    }
}
exports.TaskStatusValidationPipe = TaskStatusValidationPipe;
//# sourceMappingURL=task-status-validation.pipe.js.map