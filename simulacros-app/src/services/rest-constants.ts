export class RestConstants {
    private readonly API_URL = 'http://localhost:8080/simulacros-app-api/api/v1/';

    public getApiURL() : string {
        return this.API_URL;
    }
}