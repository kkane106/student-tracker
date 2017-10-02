import { Cohort } from './cohort';
import { Student } from './student';
import { ApplicationStep } from './application-step';

export class Application {
    id: number;
    cohort: Cohort;
    student: Student;
    createDate: Date;
    isActive: boolean;
    steps: ApplicationStep[];
}
