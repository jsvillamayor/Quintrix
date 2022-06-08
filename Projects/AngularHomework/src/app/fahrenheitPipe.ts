import { Pipe, PipeTransform } from "@angular/core";

@Pipe({name: 'FahrenheitPipe'})

export class FahrenheitPipe implements PipeTransform{
    transform(celsius: number) {
        let fah = celsius * 9 / 5 + 32;
        let output = fah.toString() + " " + '\u2109';
        return output;
    }
}