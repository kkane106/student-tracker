export class User {
    private id: number;
    private email: string;
    private password: string;

    constructor (id: number, em: string, pw: string) {
        this.id = id;
        this.email = em;
        this.password = pw;
    }
}
