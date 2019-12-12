# Software Testing Reviews

## Chap 1 intro

- purpose of testing
  - 为了发现错误
- **basic terms** 
  - **Errors** (or mistakes) – A problem that is introduced into a system during development.
  - **Faults** (defects) - A result of an error. 
  - **Failures** – The result when a fault executes. 
  - **Incidents** – The symptoms that indicates that there is a fault. 
  - **test case**
    - A set of inputs to a system 
    - An expected output 
- **lifecycle**
  - Make sure people build things with right tools and methods
  - Make sure the system has a sensible architecture
  - Use walkthroughs to make sure we agree on what is being done and how it is being done
- 最佳实践：
  - p29

## Chap 2 Black-Box Testing

### 1. black-box testing

- **def**  
  - testing based on a specification
- **tech**
  - equivalence partitions
  - boundary value analysis
- **advantages**
  - don't need to know how it is implemented

### 2. equivalence partitioning

- valid
- invalid

#### weak vs strong & normal vs robust

- **weak** 
  - Assuming a **single fault** – choose one value and select test cases for each equivalence partition
- **strong**
  - Assuming **multiple faults** - choose test cases for the combination of equivalence partitions
- **normal**
  - select values from the **‘valid’** ranges 
- **robust**
  - select values from the **‘invalid’** ranges

### 3. boundary value analysis

- focuses on the boundary of the inputs for the test cases



## Chap 3 White-Box Testing

### 1. white-box testing

- testing based on the logic in a program (implementation)
- types
  - Static Analysis 
    - code inspection
  - Dynamic Testing with path coverage of code
    - path coverage

### 2. path coverage

- **basic principles**
  - All independent paths in a module must be traversed at least once
  - All conditions (e.g. if statements) are tested for the true and false outcomes
  - Review whether the tests cover the internal data structures used
  - Test that loops work for their operational range (difficult to try ALL possible values for loops for the same reason that you cannot try ALL values for parameters)

### 3. control flow

- control flow graph
  - nodes 
  - edges
  - start and entry point
- cyclomatic complexity
  - indication of complexity
  - ways to calculate 
    - number of condition + 1
    - edge - node + 2

## Chap 4 UnitTesting

### 1. unit testing

- **def**
  - A process to check that each unit is working correctly, according to the requirements and design
- system under test
- **purpose**
  - Validate whether code is consistent with the design and requirements
  - Discover the errors between requirements, the design and implementation
- **aim**
  - ensure that module was implemented correctly
- **benefits** :a:
  - p16

### 2. test double :call_me_hand:

- **def**
  - units that are used to replace a real parts of the system for test purposes

- Depended-on Component

- **Traditional unit testing strategies **
  - Top-down unit testing strategy
  - Bottom-up unit testing strategy
  - Isolation testing 

- **types**
  - dummy object
    - data value
    - null might be used
  - test spy
  - test stub
    - insert some **logic** to respond to calls from SUT
  - mock object
    - 测试函数调用
    - **对逻辑模拟**
  - fake object
    - replaces the functionality of the Depended-on Component 
    - **对实体的模拟**

## Chap 5 Integration Testing

### 1. integration testing

- **def**
  - the phase of software testing in which individual software **modules** are combined and tested as a **group**.

  - Integration testing follows unit testing and precedes system testing

- Integration is conducted incrementally as a series of test cycles
- **Integration Testing Strategy**
  - Big Bang
  - Top-Down
  - Bottom-Up

### 2. top-down

- Breadth-First

- Depth-First

### 3. Bottom-Up

## Chap 6 System Testing

- **concept**
  - **System testing** is testing conducted on a complete, integrated system to evaluate the system's compliance with its requirements specifications. 
  - black-box testing

- **Why is system testing necessary?**
  - Some properties only verifiable at system level
    - Installation , usability, compatibility(兼容性), etc. 
  - We may involve users at this level
  - The environment of the system is taken into account
- ![image](https://user-images.githubusercontent.com/33116315/70383558-bc269000-19aa-11ea-8a7b-796428a0d6f0.png)

- **System testing method**
  - •System functionality Testing
  - •GUI Testing
  - •Usability Testing and Accessibility Testing 
  - •Performance Testing 
  - •Recovery Testing
  - •Installation Testing

## Chap 7 Performance Testing

- a form of **non-fuctional** testing
- **SMART**
  - specific
  - measurable
  - achievable
  - relevant
  - time-based
- **timing**
  - Need to have a **stable code base** for the section that is tested
- **key performance target**

  - **Availability or uptime**
  - **Concurrency**
  - **Response time** 
  - **Computer Use** 
  - **Network Use** 

## Chap 8 Software Quality Assurance and Test Management

- **methodology**
  - a way to structure our work
  - a common way to talk to our team about what we expect
  - It sets expectations on what steps we will follow as we aim to deliver the software. 
- **why do we test softwares**
  - The *purpose* is to find errors
  - To have confidence that the system meets its requirements
  - To produce a high-quality product
  - To reduce (minimize) the risk that we fail to achieve the above
- QA
  - manage the process
- QC
  - manage the product

### 1. Test Metrics

- Measure the progress of testing in an organisation and on projects 

- **example**
  - organisation
  - project
  - process
  - product

- **use of metrics**
  - Early detection of issues
  - Setting goals

## Chap 9 Design, Testing and Agile

### 1. TDD

- **TDD**
  
- Write a test, before writing the code to pass that test
  
- **pair programming**

  - **driver** and **navigator**
  
- **advantage**
    - To increase code/design quality
    - improved communication
    - More team members are familiar with the code
    - A way to train new team members
    
  
  **disadvantages**
  
  - Risk of shared assumptions
  - Personalities
  - Workstation layout
  - Need for concentration
  - May not be a good idea to pair during exploration / spike work

### 2. Testing Approaches

#### 1. Test Last

#### 2. Test First

## Chap 10 Test Automation and Quality Assurance

### 1. Automated Testing

- **Benefits**
  - speed
  - frequency
  - repeatability
  - accuracy
  - documentation
  - feedback on progress

- **key steps**
  - Run a set of tests 
  - Gather the results and process information
  - Share the results with the developers and managers

## Chap 11 Reviews

- ![image](https://user-images.githubusercontent.com/33116315/70405449-33762580-1a78-11ea-9f66-55546d486979.png)

