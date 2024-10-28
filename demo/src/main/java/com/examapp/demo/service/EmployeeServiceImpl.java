import com.examapp.demo.dao.EmployeeDao;
import com.examapp.demo.dto.EmployeeRequestDto;
import com.examapp.demo.dto.EmployeeResponseDto;
import com.examapp.demo.service.EmployeeService;
import com.examapp.demo.service.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private ModelMapper modelMapper;
    private Object Employee;

    public EmployeeServiceImpl(employeeDao employeeDao, ModelMapper modelMapper) {
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto clientRequestDto) {
        Employee = modelMapper.map(clientRequestDto, Employee.class);
        Employee saved = employeeDao.save(Employee);
        return modelMapper.map(saved, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto save() {
        return null;
    }

    @Override
    public EmployeeResponseDto findById(Integer id) {
        Employee clientEntity = employeeDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return modelMapper.map(clientEntity, EmployeeResponseDto.class);
    }

    @Override
    public EmployeeResponseDto findByNom(String nom) {
        Employee clientEntity = employeeDao.findByNom(nom);
        return modelMapper.map(clientEntity, EmployeeResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public EmployeeResponseDto update(EmployeeRequestDto clientRequestDto, Integer id) throws NotFoundException {
        return null;
    }

    @Override
    public EmployeeResponseDto update(EmployeeRequestDto clientRequestDto, Integer id) throws NotFoundException {
        Optional<EmployeeEntity> clientEntityOptional = employeeDao.findById(id);
        if (clientEntityOptional.isPresent()) {
            Employee clientEntity = modelMapper.map(clientRequestDto, Employee.class);
            employeetEntity.setId(id);
            Employee updated = employeeDao.save(clientEntity);
            return modelMapper.map(updated, EmployeeResponseDto.class);
        } else {
            throw new EntityNotFoundException("Client Not Found");
        }
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeDao.findAll()
                .stream().map(el -> modelMapper.map(el, EmployeeResponseDto.class))
                .collect(Collectors.toList());
    }
}