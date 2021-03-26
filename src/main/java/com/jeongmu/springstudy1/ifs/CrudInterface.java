package com.jeongmu.springstudy1.ifs;

import com.jeongmu.springstudy1.model.network.Header;

public interface CrudInterface {

    Header create();    // todo request object 추

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
