package com.jeongmu.springstudy1.ifs;

import com.jeongmu.springstudy1.model.network.Header;

public interface CrudInterface<Req,Res> {
// <Req, Res> >> 리퀘스트, 리스폰스에 해당하는 제네릭
    Header<Res> create(Header<Req> request);    // todo request object 추

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
