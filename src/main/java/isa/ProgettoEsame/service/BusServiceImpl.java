package isa.ProgettoEsame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.ProgettoEsame.model.Bus;
import isa.ProgettoEsame.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List < Bus > getAllBus() {
        return busRepository.findAll();
    }

    @Override
    public void saveBus(Bus bus) {
        this.busRepository.save(bus);
    }

    @Override
    public Bus getBusById(int id) {
        Optional < Bus > optional = busRepository.findById(id);
        Bus bus = null;
        if (optional.isPresent()) {
            bus = optional.get();
        } else {
            throw new RuntimeException(" Bus not found for id :: " + id);
        }
        return bus;
    }

    @Override
    public void deleteBusById(int id) {
        this.busRepository.deleteById(id);
    }
}