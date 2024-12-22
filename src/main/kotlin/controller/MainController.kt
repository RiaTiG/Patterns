package controller
import javafx.scene.input.MouseEvent
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.input.KeyEvent

class MainController {
    @FXML
    private lateinit var addButton: Button
    @FXML
    private lateinit var editButton: Button
    @FXML
    private lateinit var deleteButton: Button
    @FXML
    private lateinit var refreshButton: Button

    @FXML
    private lateinit var currentPageLabel: Label
    @FXML
    private lateinit var totalPagesLabel: Label

    @FXML
    private lateinit var nameFilterField: TextField

    @FXML
    private lateinit var gitFilterBox: ComboBox<String>
    @FXML
    private lateinit var gitSearchField: TextField

    @FXML
    private lateinit var emailFilterBox: ComboBox<String>
    @FXML
    private lateinit var emailSearchField: TextField

    @FXML
    private lateinit var phoneFilterBox: ComboBox<String>
    @FXML
    private lateinit var phoneSearchField: TextField

    @FXML
    private lateinit var telegramFilterBox: ComboBox<String>
    @FXML
    private lateinit var telegramSearchField: TextField

    @FXML
    private lateinit var studentTable: TableView<Student>
    @FXML
    private lateinit var nameColumn: TableColumn<Student, String>
    @FXML
    private lateinit var gitColumn: TableColumn<Student, String>
    @FXML
    lateinit var contactColumn: TableColumn<Student, String>

    private val students: ObservableList<Student> = FXCollections.observableArrayList(
        Student("John Doe", "github.com/johndoe", "john@example.com"),
        Student("Jane Smith", "github.com/johndoe","94949494949" ),
        Student("Alice Johnson", "github.com/alicex", "")
    )

    private val filteredStudents: ObservableList<Student> = FXCollections.observableArrayList(students)

    @FXML
    fun initialize() {
        // Инициализация колонок
        nameColumn.setCellValueFactory { SimpleStringProperty(it.value.name) }
        gitColumn.setCellValueFactory { SimpleStringProperty(it.value.git) }
        contactColumn.setCellValueFactory { SimpleStringProperty(it.value.contact) }


        studentTable.items = filteredStudents


        setupFilterBoxListeners()
    }
    private val pageSize = 20
    private var currentPage = 0
    private fun setupFilterBoxListeners() {
        setupBoxWithField(gitFilterBox, gitSearchField)
        setupBoxWithField(emailFilterBox, emailSearchField)
        setupBoxWithField(phoneFilterBox, phoneSearchField)
        setupBoxWithField(telegramFilterBox, telegramSearchField)

        nameFilterField.setOnKeyReleased { applyFilters() }
    }

    private fun setupBoxWithField(box: ComboBox<String>, field: TextField) {
        box.valueProperty().addListener { _, _, newValue ->
            field.isDisable = newValue != "Да"
            applyFilters()
        }
        field.setOnKeyReleased { applyFilters() }
    }

    private fun applyFilters() {
        filteredStudents.setAll(students.filter { student ->
            val nameMatches = student.name.contains(nameFilterField.text, ignoreCase = true)
            val gitMatches = matchesFilter(student.git, gitFilterBox.value, gitSearchField.text)
            val emailMatches = matchesFilter(student.contact, emailFilterBox.value, emailSearchField.text)
            val phoneMatches = matchesFilter(student.contact, phoneFilterBox.value, phoneSearchField.text)
            val telegramMatches = matchesFilter(student.contact, telegramFilterBox.value, telegramSearchField.text)

            nameMatches && gitMatches && emailMatches && phoneMatches && telegramMatches
        })
    }

    private fun matchesFilter(data: String, filterOption: String, filterText: String?): Boolean {
        return when (filterOption) {
            "Не важно" -> true
            "Нет" -> data.isBlank()
            "Да" -> data.contains(filterText ?: "", ignoreCase = true)
            else -> false
        }
    }


    @FXML
    private fun onPreviousPage() {
        if (currentPage > 0) {
            currentPage--
            updateTableData()
        }
    }

    @FXML
    private fun onNextPage() {
        val totalPages = getTotalPages()
        if (currentPage < totalPages - 1) {
            currentPage++
            updateTableData()
        }
    }

    private fun updateTableData() {
        val startIndex = currentPage * pageSize
        val endIndex = startIndex + pageSize
        val pageData = students.subList(startIndex, endIndex.coerceAtMost(students.size))

        studentTable.items = FXCollections.observableArrayList(pageData)
        currentPageLabel.text = (currentPage + 1).toString()
        totalPagesLabel.text = getTotalPages().toString()
    }
    private fun setupButtonState() {
        val selectedItems = studentTable.selectionModel.selectedItems
        val selectedCount = selectedItems.size

        addButton.isDisable = false
        refreshButton.isDisable = false

        when {
            selectedCount == 0 -> {
                editButton.isDisable = true
                deleteButton.isDisable = true
            }
            selectedCount == 1 -> {
                editButton.isDisable = false
                deleteButton.isDisable = false
            }
            else -> {
                editButton.isDisable = true
                deleteButton.isDisable = false
            }
        }
    }
    private fun getTotalPages(): Int {
        return if (students.size % pageSize == 0) {
            students.size / pageSize
        } else {
            (students.size / pageSize) + 1
        }
    }

    @FXML
    private fun onTableSelectionChanged(event: MouseEvent) {
        setupButtonState()
    }

    @FXML
    private fun onAdd() {
        val newStudent = Student("Новый студент", "github.com/new", "new@mail.com")
        students.add(newStudent)
        updateTableData()
    }

    @FXML
    private fun onEdit() {
        val selectedStudent = studentTable.selectionModel.selectedItem
        if (selectedStudent != null) {
            selectedStudent.contact = "updated@mail.com"
            updateTableData()
        }
    }

    @FXML
    private fun onDelete() {
        val selectedStudents = studentTable.selectionModel.selectedItems
        if (selectedStudents.isNotEmpty()) {
            students.removeAll(selectedStudents)
            updateTableData()
        }
    }

    @FXML
    private fun onRefresh() {
        updateTableData()
    }

    @FXML
    private fun onAddStudent() { /* Добавить реализацию */ }

    @FXML
    private fun onRemoveStudent() { /* Добавить реализацию */ }
}

data class Student(
    val name: String,
    val git: String = "",
    var contact: String = "",

    )
