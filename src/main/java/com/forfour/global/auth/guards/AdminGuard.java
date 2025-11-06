package com.forfour.global.auth.guards;

import com.forfour.domain.member.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class AdminGuard extends Guard implements Authorizable {

    public AdminGuard() {
        super(Role.ADMIN);
    }

    @Override
    public boolean isAuthorized(Role role) {
        return this.role.equals(role);
    }
}
