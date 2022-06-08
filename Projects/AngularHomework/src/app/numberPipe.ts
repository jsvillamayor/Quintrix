import { Pipe, PipeTransform } from "@angular/core";

@Pipe({name: 'NumberPipe'})

export class NumberPipe implements PipeTransform{
    transform(num: number) {
        let initNum = num.toString();
        let output = "(" + initNum.substr(0, 3) + ") " + initNum.substr(3,3) + "-" + initNum.substr(6,4);
        return output;
    }
}