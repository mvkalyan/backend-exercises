import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  constructor(private httpClient:HttpClient) { }

  baseUrl="http://localhost:12345/movie-app/v1";

  getAllMovies(){
    return this.httpClient.get(this.baseUrl+"/movies");
  }

  addMovie(movie: any){
    return this.httpClient.post(this.baseUrl+"/movie",movie);
  }

  deleteMovie(movieId: number){
    let httpHeaders = new HttpHeaders({
      "authorization":'Bearer '+localStorage.getItem('token')
    });
    console.log(localStorage.getItem('token'));
    let requestOptions={headers:httpHeaders};

    return this.httpClient.delete(this.baseUrl+"/delete-movie/"+movieId,requestOptions);
  }

  updateMovie(movie:any){
    return this.httpClient.put(this.baseUrl+"/movie",movie)
  }
}