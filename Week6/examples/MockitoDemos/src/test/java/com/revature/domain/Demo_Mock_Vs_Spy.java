package com.revature.domain;

//Mock vs Spy - understanding the difference

//Mock: completely fake - all methods return defaults until stubbed
//Spy: Real object wrapper - real methods execute unless stubbed
//Use Mock for: complete isolation, testing interactions
//Use Spy for: Partial mocking, legacy code, need some real behavior

//Caution: Overusing spies often indicates design problems!

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Mock vs Spy Demo")
public class Demo_Mock_Vs_Spy {

    //Spy Behavior

    @Spy
    private List<String> spyList = new ArrayList<>();

    @Test
    @DisplayName("Spy: real methods execute")
    void demonstrateSpyBehavior(){
        //Spy wraps a real ArrayList - methods actually work!

        spyList.add("item1");
        spyList.add("item2");

        //Real behavior - items were actually added
        assertEquals(2,spyList.size(),"Spy actuall has items");
        assertEquals("item1",spyList.get(0));
        assertEquals("item2",spyList.get(1));


    }

    @Test
    @DisplayName("Spy: can selectively override methods")
    void demonstrateSpySelectiveStubbing(){
        //Create fresh spy
        List<String> freshSpy = spy(new ArrayList<>());

        //Add real items
        freshSpy.add("real1");
        freshSpy.add("real2");

        assertEquals(2,freshSpy.size(), "Real size before stubbing");

        //Now stub just the size() method
        when(freshSpy.size()).thenReturn(100);

        //Size is stubbed, but data is still real
        assertEquals(100,freshSpy.size(),"Size is stubbed");
        assertEquals("real1",freshSpy.get(0),"Data is still real");
        assertEquals("real2",freshSpy.get(1),"Data is still real");

    }

}
