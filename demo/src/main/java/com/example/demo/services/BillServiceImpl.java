package com.example.demo.services;

import com.example.demo.dao.BillDao;
import com.example.demo.models.Bill;
import com.example.demo.models.CreateBillRequest;
import com.example.demo.models.PaymentRequest;
import org.springframework.stereotype.Service;
import com.example.demo.models.Bill.PaymentStatus;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService{

    BillDao billDao;

    public BillServiceImpl(BillDao billDao) {
        this.billDao = billDao;
    }


    @Override
    public Long createBill(CreateBillRequest request) {
        Bill bill = new Bill();
        bill.setUserId(Long.valueOf(request.getUserId()));
        bill.setProviderId(Long.valueOf(request.getProviderId()));
        bill.setAmount(request.getAmount());
        bill.setDueDate(request.getDueDate());
        bill.setPaidAmount(0);
        bill.setDueAmount(request.getAmount());
        bill.setPaymentStatus(PaymentStatus.PENDING);
        Bill createdBill = billDao.save(bill);
        return createdBill.getBillId();
    }

    @Override
    public Long updateBill(PaymentRequest request) {
        Optional<Bill> billOptional = billDao.findById(Long.valueOf(request.getBillId()));
        Bill updatedBill = null;
        if(billOptional.isPresent()){
           Bill bill  = billOptional.get();
           if(bill.getDueAmount() > 0){
               bill.setPaidAmount(bill.getPaidAmount()+request.getAmountPaid());
               bill.setDueAmount(bill.getDueAmount()-request.getAmountPaid());
               if(bill.getAmount() == bill.getPaidAmount()) bill.setPaymentStatus(Bill.PaymentStatus.PAID);
               else if(bill.getPaidAmount() >0)bill.setPaymentStatus(PaymentStatus.PARTIALLY_PAID);
               updatedBill =   billDao.save(bill);
           }

           return updatedBill != null ? updatedBill.getBillId() : Long.valueOf(request.getBillId());
        }else{
            return null;
        }
    }

    @Override
    public List<Bill> getPendingBillsForUserId(String userId) {
        Optional<List<Bill>> billList = billDao.getPendingBillsForUserId(userId);
        return billList.orElse(null);
    }

    @Override
    public List<Bill> getAllBillsForProviderId(String providerId) {
        Optional<List<Bill>> billList = billDao.findByServiceProviderId(providerId);
        return billList.orElse(null);
    }

    @Override
    public Bill getBill(Long billId){
        Optional<Bill> bill = billDao.findById(billId);
        return bill.orElse(null);
    }

    @Override
    public List<Bill> listAllBillsForUser(String userId) {
        Optional<List<Bill>> billList = billDao.findByUserId(userId);
        return billList.orElse(null);
    }
}
