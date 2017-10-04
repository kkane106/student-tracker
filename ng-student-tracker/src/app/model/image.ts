export class Image {
    private id: number;
    private url: string;
    private title: string;

    constructor(id: number, url: string, title: string) {
        this.id = id;
        this.url = url;
        this.title = title;
    }
}
