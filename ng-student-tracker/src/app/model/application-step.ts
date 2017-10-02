import { Application } from './application';
import { ApplicationTask} from './application-task';

export class ApplicationStep {
    id: number;
    application: Application;
    task: ApplicationTask;
    completedDate: Date;
    isAcceptable: boolean;
}
