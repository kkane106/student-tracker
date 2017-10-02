import { ContactType } from './contact-type';

export class Contact {
    id: number;
    fname: string;
    lname: string;
    email: string;
    phone: string;
    type: ContactType;
}
