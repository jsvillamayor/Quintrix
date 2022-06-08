import { Component } from "@angular/core";

@Component({
    template: `This is page A.<br>This content was set in page-b: {{someItem}} {{someItem2}}`
})

export class PageAComponent {
    someItem: string | null;
    someItem2: string | null;
    constructor(){
        if(sessionStorage.getItem("autosave") && sessionStorage.getItem("autosave2")){
            this.someItem = sessionStorage.getItem("autosave");
            this.someItem2 = sessionStorage.getItem("autosave");
        }
    }
}