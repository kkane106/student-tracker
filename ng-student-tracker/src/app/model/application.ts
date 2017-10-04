import { Cohort } from './cohort';
import { Student } from './student';
import { ApplicationStep } from './application-step';

export class Application {
    private id: number;
    private cohort: Cohort;
    private student: Student;
    private createDate: Date;
    private isActive: boolean;
    private steps: ApplicationStep[];

    constructor(id: number, coh: Cohort, stud: Student, createDate: Date, active: boolean, steps: ApplicationStep[]) {
        this.id = id;
        this.cohort = coh;
        this.student = stud;
        this.createDate = createDate;
        this.isActive = active;
        this.steps = steps;
    }
}
