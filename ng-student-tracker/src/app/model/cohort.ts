import { Student } from './student';
import { Application } from './application';

export class Cohort {
    private id: number;
    private name: string;
    private nickname: string;
    private startDate: Date;
    private endDate: Date;
    private capacity: number;
    private students: Student[];
    private applications: Application[];

    constructor(id: number, name: string, nickname: string, start: Date, end: Date, capacity: number) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.startDate = start;
        this.endDate = end;
        this.capacity = capacity;
    }
}
