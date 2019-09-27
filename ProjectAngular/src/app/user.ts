import { Role } from './role';

export class User {
    Id: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    address: string;
    email: string;
    middleInit: string;
    state: string;
    zip: number;
    number: number;
    role: Role;
}
