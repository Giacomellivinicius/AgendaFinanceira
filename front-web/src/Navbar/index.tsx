import React from 'react';
import'./styles.css';
import logo from '../images/logo-sec.png';
import AccountsTotal from '../components/AccountsTotal';
import Date from '../components/DateHeader';

function Navbar(){
    return (
        <nav className="main-navbar">
            <img className="navbar-logo" src={logo} alt="logo-sec"/>
            <h1 className="logo-text">USER</h1>
            <AccountsTotal/>
            <Date/>
        </nav>
    )

}

export default Navbar;