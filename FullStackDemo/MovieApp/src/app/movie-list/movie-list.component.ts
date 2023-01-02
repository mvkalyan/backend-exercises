import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginComponent } from '../login/login.component';
import { MovieServiceService } from '../movie-service.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  constructor(private movieService: MovieServiceService,private userService:UserService) {
    this.getAllMovie();
    this.formFlag=false;
  }

  private loginObj!: LoginComponent;

  ngOnInit(): void {
  }

  movieData:any;
  formFlag:boolean;

  getAllMovie(){
    this.movieService.getAllMovies().subscribe(
      response=>{
        this.movieData=response;
        this.formFlag=false;
      }
    )
  }

  movieForm=new FormGroup({
    "movieId": new FormControl(""),
    "movieName": new FormControl(""),
    "movieHero": new FormControl(""),
    "movieBudget": new FormControl("")
  });

  movieUpdateForm=new FormGroup({
    "movieId": new FormControl(""),
    "movieName": new FormControl(""),
    "movieHero": new FormControl(""),
    "movieBudget": new FormControl("")
  });

  saveMovieData(){
    this.movieService.addMovie(this.movieForm.value).subscribe(
      response=>{
        alert("Movie added to the database");
        this.getAllMovie();
        this.formFlag=false;
      }
    )
  }

  deleteMovie(movieId:number){
    this.movieService.deleteMovie(movieId).subscribe(
      r=>{
        alert("Movie deleted successfully");
        this.getAllMovie();
        this.formFlag=false;
      }
    )
  }

  movieUpdate(){
    this.movieService.updateMovie(this.movieUpdateForm.value).subscribe(
      r=>{
        alert("Movie updated successfully");
        this.getAllMovie();
        this.formFlag=false;
      }
    )
  }

  formEnable(movie:any){
    this.formFlag=true;
    this.movieUpdateForm.setValue(movie);
  }
  
  logout(){
    this.userService.logoutUser();
  }
}