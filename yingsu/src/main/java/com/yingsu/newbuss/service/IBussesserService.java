package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TBussesser;
import org.springframework.stereotype.Service;

public interface IBussesserService {
    TBussesser getBussersser(Integer bussesserId);
}
