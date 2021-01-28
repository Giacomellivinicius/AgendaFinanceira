import React from 'react';
import './styles.css';

let dayName = new Array ("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb");
let monName = new Array ("Janeiro", "fevereiro", "março", "abril", "maio", "junho", "agosto", "outubro", "novembro", "dezembro");
let now = new Date();

//Falta Atualizar com frequência

function DateHeader(){
    return (
        <div className="navbar-date">
            <p className="navbar-date-text"> {dayName[now.getDay()]}, {now.getDay()} de {monName[now.getMonth()]} de {now.getFullYear()}</p><br/>
                <div className="navbar-hour">
                    <p id="time">{now.getHours()}:{now.getMinutes()}</p>
                </div>
        </div>

    )

}

export default DateHeader;