package com.multi.q1;

public class DeptVO {
    int deptNo;
    String dname;
    String loc;

    public int getdeptNo() {
        return deptNo;
    }

    public void setdeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getdname() {
        return dname;
    }

    public void setdname(String dname) {
        this.dname = dname;
    }

    public String getloc() {
        return loc;
    }

    public void setloc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "MemberVO [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
    }
}
