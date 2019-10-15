package com.join.joinblog.service.invitecode;

import java.util.List;

public interface InviteCodeService {
    boolean addCode(String code);

    List getCodes();

    boolean deleteCode(int id);
}
