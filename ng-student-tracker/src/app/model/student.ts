import { User } from './user';
import { Address } from './address';
import { Image } from './image';
import { Contact } from './contact';

export class Student {
    private id: number;
    private fname: string;
    private lname: string;
    private isVa: boolean;
    private user: User;
    private address: Address;
    private image: Image;
    private contacts: Contact[];

    constructor(id: number, f: string, l: string,
                va: boolean) {
        this.id = id;
        this.fname = f;
        this.lname = l;
        this.isVa = va;
    }
}
