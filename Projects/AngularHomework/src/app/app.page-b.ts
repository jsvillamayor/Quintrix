import { Component, Input } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    template: `This is page b. {{retrievedFromStorage}}
    <input type="input" (ngModelChange)="mychange($event)" [ngModel]="mymodel">
    <input type="input" (ngModelChange)="mychange2($event)" [ngModel]="mymodel2">
    `
})

export class PageBComponent {
    id: number;
    firstName: string;
    retrievedFromStorage: string;
    mymodel: string;
    mymodel2: string;

    constructor(private route: ActivatedRoute){
        let str = "This is where the class is initialized.";
        console.log(str);
    }

    mychange(val: string){
        sessionStorage.setItem("autosave", val);
        console.log(val);
    }

    mychange2(val2: string){
        sessionStorage.setItem("autosave2", val2);
        console.log(val2);
    }

    ngOnInit(){
        this.route.params.forEach((params: Params) => {
            let localID = params['id'];
            let localName = params['firstname'];
            this.id = localID;
            this.firstName = localName;
        });
    }

}