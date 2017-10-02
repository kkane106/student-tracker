import { Student } from './student';
import { Application } from './application';

export class Cohort {
    id: number;
    name: string;
    nickname: string;
    startDate: Date;
    endDate: Date;
    capacity: number;
    students: Student[];
    applications: Application[];
}
