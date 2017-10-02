import { User } from './user';
import { Address } from './address';
import { Image } from './image';
import { Contact } from './contact';

export class Student {
    id: number;
    fname: string;
    lname: string;
    isVa: boolean;
    user: User;
    address: Address;
    image: Image;
    contacts: Contact[];
}
