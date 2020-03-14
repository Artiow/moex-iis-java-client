package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public enum SecurityPaperDescriptionKey {

    SECID("Security code", String.class),
    SHORTNAME("Short name", String.class),
    NAME("Full name", String.class),
    LATNAME("Full name in English", String.class),
    LOTSIZE("Lot size", Number.class),
    QUOTATION("Quotation", Number.class),
    TYPENAME("Security type", String.class),
    GROUP("Instrument type code", String.class),
    TYPE("Security type", String.class),
    GROUPNAME("Instrument type", String.class),
    ISIN("ISIN Code", String.class),
    REGNUMBER("State registration number", String.class),
    ISSUESIZE("Issue Size", Number.class),
    FACEVALUE("Face value", Number.class),
    FACEUNIT("Face value currency", String.class),
    ISSUEDATE("Date of listing", Date.class),
    LISTLEVEL("List level", Number.class),
    ISQUALIFIEDINVESTORS("Qualified investors", Boolean.class),
    EMITTERID("Emitter code", Number.class),
    MATDATE("Maturity date", Date.class),
    INITIALFACEVALUE("Initial face value", Number.class),
    STARTDATEMOEX("Trading start date on Moscow Exchange", Date.class),
    PROGRAMREGISTRYNUMBER("State registration number of the bond program ", String.class),
    EARLYREPAYMENT("Option for early redemption", Boolean.class),
    DAYSTOREDEMPTION("Days to redemption", Number.class),
    COUPONFREQUENCY("Coupon payment interval in year", Number.class),
    COUPONDATE("Coupon date", Date.class),
    COUPONPERCENT("Coupon rate, %", Number.class),
    COUPONVALUE("Coupon value, in face value currency", Number.class);


    private final String description;
    private final Class<? extends Serializable> type;
}
