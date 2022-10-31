package isa.ProgettoEsame.service;

import java.util.List;

import isa.ProgettoEsame.model.Bus;

public interface BusService {
    List < Bus > getAllBus();
    void saveBus(Bus bus);
    Bus getBusById(int id);
    void deleteBusById(int id);
}
