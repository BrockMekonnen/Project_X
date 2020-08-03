package com.AASTU.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="Age_Scale")
public class AgeScale {
    @Id
    @Column(name="Day")
    private LocalDate date;
    @Column(name ="Male_Less_Than_1")
    private int mLess1;
    @Column(name="Male_Between_1_and_4")
    private int m1to4;
    @Column(name = "Male_between_5_and_14")
    private int m5to14;
    @Column(name = "Male_between_15_and_29")
    private int m15to29;
    @Column(name = "Male_between_30_and_64")
    private int m30to64;
    @Column(name = "Male_Greater_Than_65")
    private int mGreater65;
    @Column(name ="Female_Less_Than 1")
    private int fLess1;
    @Column(name ="Female_Between_1_and_4")
    private int f1to4;
    @Column(name ="Female_Between_5_and_14")
    private int f5to14;
    @Column(name ="Female_Between_15_and_29")
    private int f15to29;
    @Column(name ="Female_Between_30_and_64")
    private int f30to64;
    @Column(name ="Female_Greater_Than_65")
    private int fGreater65;

    public AgeScale(LocalDate date,int mLess1, int m1to4, int m5to14, int m15to29, int m30to64, int mGreater65, int fLess1, int f1to4, int f5to14, int f15to29, int f30to64, int fGreater65) {
        this.date=date;
        this.mLess1 = mLess1;
        this.m1to4 = m1to4;
        this.m5to14 = m5to14;
        this.m15to29 = m15to29;
        this.m30to64 = m30to64;
        this.mGreater65 = mGreater65;
        this.fLess1 = fLess1;
        this.f1to4 = f1to4;
        this.f5to14 = f5to14;
        this.f15to29 = f15to29;
        this.f30to64 = f30to64;
        this.fGreater65 = fGreater65;
    }

    public int getmLess1() {
        return mLess1;
    }

    public void setmLess1(int mLess1) {
        this.mLess1 = mLess1;
    }

    public int getM1to4() {
        return m1to4;
    }

    public void setM1to4(int m1to4) {
        this.m1to4 = m1to4;
    }

    public int getM5to14() {
        return m5to14;
    }

    public void setM5to14(int m5to14) {
        this.m5to14 = m5to14;
    }

    public int getM15to29() {
        return m15to29;
    }

    public void setM15to29(int m15to29) {
        this.m15to29 = m15to29;
    }

    public int getM30to64() {
        return m30to64;
    }

    public void setM30to64(int m30to64) {
        this.m30to64 = m30to64;
    }

    public int getmGreater65() {
        return mGreater65;
    }

    public void setmGreater65(int mGreater65) {
        this.mGreater65 = mGreater65;
    }

    public int getfLess1() {
        return fLess1;
    }

    public void setfLess1(int fLess1) {
        this.fLess1 = fLess1;
    }

    public int getF1to4() {
        return f1to4;
    }

    public void setF1to4(int f1to4) {
        this.f1to4 = f1to4;
    }

    public int getF5to14() {
        return f5to14;
    }

    public void setF5to14(int f5to14) {
        this.f5to14 = f5to14;
    }

    public int getF15to29() {
        return f15to29;
    }

    public void setF15to29(int f15to29) {
        this.f15to29 = f15to29;
    }

    public int getF30to64() {
        return f30to64;
    }

    public void setF30to64(int f30to64) {
        this.f30to64 = f30to64;
    }

    public int getfGreater65() {
        return fGreater65;
    }

    public void setfGreater65(int fGreater65) {
        this.fGreater65 = fGreater65;
    }


}
