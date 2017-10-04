import { Application } from './application';

export class ApplicationTask {
    private id: number;
    private name: string;
    private description: string;
    private isActive: boolean;
    private order: number;

    constructor(id: number, name: string, description: string, active: boolean, order: number) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = active;
        this.order = order;
    }
}
