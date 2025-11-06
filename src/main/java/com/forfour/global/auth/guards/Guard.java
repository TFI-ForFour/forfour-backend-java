package com.forfour.global.auth.guards;


import com.forfour.domain.member.entity.Role;

public abstract class Guard {
    public final Role role;

    protected Guard(Role role) {
        this.role = role;
    }

}
