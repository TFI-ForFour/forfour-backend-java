package com.forfour.global.auth.guards;

import com.forfour.domain.member.entity.Role;

public interface Authorizable {

    boolean isAuthorized(Role role);

}
