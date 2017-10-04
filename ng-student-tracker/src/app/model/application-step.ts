import { Application } from './application';
import { ApplicationTask} from './application-task';

export class ApplicationStep {
    private id: number;
    private application: Application;
    private task: ApplicationTask;
    private completedDate: Date;
    private isAcceptable: boolean;

    constructor(id: number, app: Application, task: ApplicationTask, completed: Date, acceptable: boolean) {
        this.id = id;
        this.application = app;
        this.task = task;
        this.completedDate = completed;
        this.isAcceptable = acceptable;
    }
}
