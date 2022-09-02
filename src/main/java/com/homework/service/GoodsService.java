package com.homework.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.homework.pojo.Goods;

public interface GoodsService {
    public IPage<Goods> getGoods(int cid, String bname, String keyword, Integer pageno, String ordercol, int order);
}
