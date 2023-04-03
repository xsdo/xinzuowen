<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名称" prop="tName">
        <el-input
          v-model="queryParams.tName"
          placeholder="请输入名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="绑定学校id" prop="tSchoolid">
        <el-input
          v-model="queryParams.tSchoolid"
          placeholder="请输入绑定学校id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年级" prop="tGrade">
        <el-input
          v-model="queryParams.tGrade"
          placeholder="请输入年级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学期" prop="tTerm">
        <el-input
          v-model="queryParams.tTerm"
          placeholder="请输入学期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生人数" prop="tStudent">
        <el-input
          v-model="queryParams.tStudent"
          placeholder="请输入学生人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班级鲜花数" prop="tFlowers">
        <el-input
          v-model="queryParams.tFlowers"
          placeholder="请输入班级鲜花数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教师姓名" prop="teaName">
        <el-input
          v-model="queryParams.teaName"
          placeholder="请输入教师姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写作数" prop="writes">
        <el-input
          v-model="queryParams.writes"
          placeholder="请输入写作数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="阅读数" prop="readings">
        <el-input
          v-model="queryParams.readings"
          placeholder="请输入阅读数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="朗读数" prop="readalouds">
        <el-input
          v-model="queryParams.readalouds"
          placeholder="请输入朗读数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班级开关 0不可加入" prop="tOpen">
        <el-input
          v-model="queryParams.tOpen"
          placeholder="请输入班级开关 0不可加入"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排名" prop="rankings">
        <el-input
          v-model="queryParams.rankings"
          placeholder="请输入排名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="老师id" prop="teacherId">
        <el-input
          v-model="queryParams.teacherId"
          placeholder="请输入老师id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['users:teacher:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['users:teacher:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['users:teacher:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['users:teacher:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teacherList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="名称" align="center" prop="tName" />
      <el-table-column label="绑定学校id" align="center" prop="tSchoolid" />
      <el-table-column label="年级" align="center" prop="tGrade" />
      <el-table-column label="学期" align="center" prop="tTerm" />
      <el-table-column label="二维码" align="center" prop="qrCode" />
      <el-table-column label="学生人数" align="center" prop="tStudent" />
      <el-table-column label="班级鲜花数" align="center" prop="tFlowers" />
      <el-table-column label="班级头像" align="center" prop="tImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.tImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="教师姓名" align="center" prop="teaName" />
      <el-table-column label="教师头像" align="center" prop="teaImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.teaImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="教师签名" align="center" prop="teaSign" />
      <el-table-column label="班级口号" align="center" prop="tSlogan" />
      <el-table-column label="写作数" align="center" prop="writes" />
      <el-table-column label="阅读数" align="center" prop="readings" />
      <el-table-column label="朗读数" align="center" prop="readalouds" />
      <el-table-column label="班级开关 0不可加入" align="center" prop="tOpen" />
      <el-table-column label="排名" align="center" prop="rankings" />
      <el-table-column label="老师id" align="center" prop="teacherId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['users:teacher:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['users:teacher:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改教师班级对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="名称" prop="tName">
          <el-input v-model="form.tName" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="绑定学校id" prop="tSchoolid">
          <el-input v-model="form.tSchoolid" placeholder="请输入绑定学校id" />
        </el-form-item>
        <el-form-item label="年级" prop="tGrade">
          <el-input v-model="form.tGrade" placeholder="请输入年级" />
        </el-form-item>
        <el-form-item label="学期" prop="tTerm">
          <el-input v-model="form.tTerm" placeholder="请输入学期" />
        </el-form-item>
        <el-form-item label="二维码" prop="qrCode">
          <el-input v-model="form.qrCode" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学生人数" prop="tStudent">
          <el-input v-model="form.tStudent" placeholder="请输入学生人数" />
        </el-form-item>
        <el-form-item label="班级鲜花数" prop="tFlowers">
          <el-input v-model="form.tFlowers" placeholder="请输入班级鲜花数" />
        </el-form-item>
        <el-form-item label="班级头像" prop="tImage">
          <image-upload v-model="form.tImage"/>
        </el-form-item>
        <el-form-item label="教师姓名" prop="teaName">
          <el-input v-model="form.teaName" placeholder="请输入教师姓名" />
        </el-form-item>
        <el-form-item label="教师头像" prop="teaImage">
          <image-upload v-model="form.teaImage"/>
        </el-form-item>
        <el-form-item label="教师签名" prop="teaSign">
          <el-input v-model="form.teaSign" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="班级口号" prop="tSlogan">
          <el-input v-model="form.tSlogan" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="写作数" prop="writes">
          <el-input v-model="form.writes" placeholder="请输入写作数" />
        </el-form-item>
        <el-form-item label="阅读数" prop="readings">
          <el-input v-model="form.readings" placeholder="请输入阅读数" />
        </el-form-item>
        <el-form-item label="朗读数" prop="readalouds">
          <el-input v-model="form.readalouds" placeholder="请输入朗读数" />
        </el-form-item>
        <el-form-item label="班级开关 0不可加入" prop="tOpen">
          <el-input v-model="form.tOpen" placeholder="请输入班级开关 0不可加入" />
        </el-form-item>
        <el-form-item label="排名" prop="rankings">
          <el-input v-model="form.rankings" placeholder="请输入排名" />
        </el-form-item>
        <el-form-item label="老师id" prop="teacherId">
          <el-input v-model="form.teacherId" placeholder="请输入老师id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTeacher, getTeacher, delTeacher, addTeacher, updateTeacher } from "@/api/users/teacher";

export default {
  name: "Teacher",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 教师班级表格数据
      teacherList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        tName: null,
        tSchoolid: null,
        tGrade: null,
        tTerm: null,
        qrCode: null,
        tStudent: null,
        tFlowers: null,
        tImage: null,
        teaName: null,
        teaImage: null,
        teaSign: null,
        tSlogan: null,
        writes: null,
        readings: null,
        readalouds: null,
        tOpen: null,
        rankings: null,
        teacherId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询教师班级列表 */
    getList() {
      this.loading = true;
      listTeacher(this.queryParams).then(response => {
        this.teacherList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        tName: null,
        tSchoolid: null,
        tGrade: null,
        tTerm: null,
        qrCode: null,
        tStudent: null,
        tFlowers: null,
        tImage: null,
        teaName: null,
        teaImage: null,
        teaSign: null,
        tSlogan: null,
        writes: null,
        readings: null,
        readalouds: null,
        tOpen: null,
        rankings: null,
        teacherId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教师班级";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTeacher(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教师班级";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTeacher(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeacher(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除教师班级编号为"' + ids + '"的数据项？').then(function() {
        return delTeacher(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('users/teacher/export', {
        ...this.queryParams
      }, `teacher_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
