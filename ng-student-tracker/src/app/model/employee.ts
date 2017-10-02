import { User } from './user';
import { Contact } from './contact';

export class Employee {
    id: number;
    fname: string;
    lname: string;
    user: User;
    contacts: Contact[];
}
