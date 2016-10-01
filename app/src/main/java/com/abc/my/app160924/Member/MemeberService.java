package com.abc.my.app160924.Member;

import com.abc.my.app160924.Util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemeberService {

    public MemberDTO login(MemberDTO member);
    public Retval join(MemberDTO member);

}
