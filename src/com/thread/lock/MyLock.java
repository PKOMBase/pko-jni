package com.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private final Sync sync;

    public MyLock() {
        sync = new Sync();
    }

    static class Sync extends AbstractQueuedSynchronizer {

        public void lock() {
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            final Thread current = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                // // 获取,首先判断是否有排队的(公平)
                // boolean hasQueuedPredecessors = hasQueuedPredecessors();
                // if (hasQueuedPredecessors) {
                // return false;
                // }
                // state
                compareAndSetState(0, arg);
                // thread
                setExclusiveOwnerThread(current);
                return true;
            } else if (getExclusiveOwnerThread() == current) {
                // state+1
                int newState = state + arg;
                setState(newState);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            final Thread current = Thread.currentThread();
            if (getExclusiveOwnerThread() != current) {
                throw new IllegalMonitorStateException();
            }

            int newState = getState() - arg;
            // state-1
            setState(newState);
            if (newState == 0) {
                // thread = null
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }

        @Override
        protected boolean isHeldExclusively() {
            return this.getExclusiveOwnerThread() == Thread.currentThread();
        }
    }

    @Override
    public void lock() {
        sync.lock();
        // sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.new ConditionObject();
    }

}
