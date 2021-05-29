import React, { Component, useState, SyntheticEvent  } from "react";
import axios from "axios";
import styled from 'styled-components';


const H0 = styled.h1({
    fontSize: 25,
    paddingBottom: 30,
    paddingTop: 20,
    color: 'black',
    textAlign: "center"
});

const H1 = styled.h1({
    paddingBottom: 30,
    fontSize: 12,
    paddingTop: 0,
    textAlign: "center"
});


class Comp1 extends React.Component {

    constructor(props){
      super(props);
        this.state = {
            students: [
                { id: 1,Date: '15/05/2019 08:48           ', CO: '0', TEMP: 21, HGT: 2, PRES: 0.9, NO2: -1, HUM: 35, Lum:100, BATERY:0 },
                { id: 2,Date: '15/05/2019 08:48           ', CO: '0', TEMP: 24, HGT: 3, PRES: 0.9, NO2: -1, HUM: 35, Lum:100, BATERY:0 },
                { id: 3,Date: '15/05/2019 08:48           ', CO: '0', TEMP: 21, HGT: 3, PRES: 0.9, NO2: -1, HUM: 39, Lum:100, BATERY:0 },
                { id: 4,Date: '15/05/2019 08:49           ', CO: '0', TEMP: 21, HGT: 3, PRES: 0.9, NO2: -1, HUM: 40, Lum:100, BATERY:0 },
                { id: 5,Date: '15/05/2019 08:49', CO: '0', TEMP: 29, HGT: 2, PRES: 0.9, NO2: -1, HUM: 31, Lum:101, BATERY:0 },
                { id: 6,Date: '15/05/2019 08:49', CO: '4', TEMP: 21, HGT: 2, PRES: 0.9, NO2: -1, HUM: 31, Lum:101, BATERY:0 },
                { id: 7,Date: '15/05/2019 08:50', CO: '0', TEMP: 21, HGT: 2, PRES: 0.9, NO2: -1, HUM: 31, Lum:100, BATERY:0 },
                { id: 8,Date: '15/05/2019 08:50', CO: '0', TEMP: 17, HGT: 2, PRES: 0.9, NO2: -1, HUM: 35, Lum:100, BATERY:0},
                { id: 9,Date: '15/05/2019 08:50', CO: '5', TEMP: 18, HGT: 3, PRES: 0.9, NO2: -1, HUM: 35, Lum:100, BATERY:0 },
                { id: 10,Date: '15/05/2019 08:51', CO: '0', TEMP: 21, HGT: 2, PRES: 0.9, NO2:-1, HUM: 41, Lum:101, BATERY:0 },
                { id: 11,Date: '15/05/2019 08:52', CO: '0', TEMP: 17, HGT: 3, PRES: 0.9, NO2:-1, HUM: 37, Lum:101, BATERY:0 },
                { id: 12,Date: '15/05/2019 08:59', CO: '0', TEMP: 21, HGT: 3, PRES: 0.9, NO2: -1, HUM:37, Lum:101, BATERY:0 },
                { id: 13,Date: '15/05/2019 09:00', CO: '0', TEMP: 27, HGT: 2, PRES: 0.9, NO2: -1, HUM: 41, Lum:100, BATERY:0 },
                { id: 14,Date: '15/05/2019 09:01', CO: '0', TEMP: 25, HGT: 1, PRES: 0.9, NO2: -1, HUM: 41, Lum:100, BATERY:0 }

            ]
        }
      //this.loadData = this.loadData.bind(this);
    }

    //componentDidMount(){
    //  this.loadData();
    //  setInterval(this.loadData, 10000);

    //}

    /*async loadData() {
        try {
            axios.get("http://localhost:8081/gps").then(response => {
                this.setState({ armys: response.data })
            });
        } catch (e) {
            console.log(e);
        }
    }*/

    renderTableHeader() {
        let header = Object.keys(this.state.students[0])
        return header.map((key, index) => {
            return <th key={index}>{key.toUpperCase()}</th>
        })
    }


    renderTableData() {
        return this.state.students.map((student, index) => {
            const { id, Date, CO, TEMP, HGT, PRES, NO2, HUM, Lum, BATERY } = student //destructuring
            return (
                <tr key={id}>
                    <td>{id}</td>
                    <td>{Date}</td>
                    <td>{CO}</td>
                    <td>{TEMP}</td>
                    <td>{HGT}</td>
                    <td>{PRES}</td>
                    <td>{NO2}</td>
                    <td>{HUM}</td>
                    <td>{Lum}</td>
                    <td>{BATERY}</td>
                </tr>
            )
        })
    }

    render() {
        return (
            <div>
                <h1 id='title'>Bombeiros v1 - GPS Data</h1><br/>

                <table id='students'>
                    <tbody>
                    <tr>{this.renderTableHeader()}</tr>
                    {this.renderTableData()}
                    </tbody>
                </table>
            </div>
        )
    }

    /*
    render(){
        return(
            <div>
                <H0 className="text-center" > All planes <b>Get In</b> the <b>Iberian Peninsula</b> </H0>

                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td>yMdHms</td>
                        <td>Lat</td>
                        <td>Long</td>
                        <td>tag</td>
                        <td>Alt</td>
                        <td>val</td>

                    </tr>
                    </thead>
                    <tbody id="myTable"> { this.state.armys.map( arm =>
                        <tr key = {arm.Lat}>
                            <td>{arm.yMdHms}</td>
                            <td>{arm.Lat}</td>
                            <td>{arm.Long}</td>
                            <td>{arm.tag}</td>
                            <td>{arm.Alt}</td>
                            <td>{arm.val}</td>
                        </tr>
                    )
                    }
                    </tbody>
                </table>
            </div>
        );
    } */
}

export default Comp1